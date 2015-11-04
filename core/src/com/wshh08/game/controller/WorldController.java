package com.wshh08.game.controller;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by wshh08 on 15-11-1.
 */
public class WorldController extends InputAdapter{  /*InputAdapter为输入监听器接口*/
    private static final String TAG = WorldController.class.getName();
    public Sprite[] testSprites;
    public int selectedSprite;

    public WorldController() {
        init();
    }
    private void init() {
        Gdx.input.setInputProcessor(this);
        initTestObjects();
    }
    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.R) {
            init();
            Gdx.app.debug(TAG, "Game World resetted");
        }
        else if (keycode == Input.Keys.SPACE) {
            selectedSprite  = (selectedSprite + 1) % testSprites.length;
            Gdx.app.debug(TAG, "Sprite #" + selectedSprite + " selected");
        }
        return false;
    }
    public void initTestObjects() {
        testSprites = new Sprite[5];
        int width = 32;
        int height = 32;
        Pixmap pixmap = createProceduralPixmap(width, height);
        Texture texture = new Texture(pixmap);
        for (int i = 0; i < 5; i++) {
            Sprite spr = new Sprite(texture);
            spr.setSize(1, 1);
            spr.setOrigin(spr.getWidth() / 2.0f, spr.getHeight() / 2.0f);
            float randomX = MathUtils.random(1f, 4f);
            float randomY = MathUtils.random(1f, 4f);
            spr.setPosition(randomX, randomY);
            testSprites[i] = spr;
        }
        selectedSprite = 0;
    }
    private Pixmap createProceduralPixmap(int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(1, 0, 0, 0.5f);
        pixmap.fill();
        pixmap.setColor(1, 1, 0, 1);
        pixmap.drawLine(0, 0, width, height);
        pixmap.drawLine(width, 0, 0, height);
        pixmap.setColor(0, 1, 1, 1);
        pixmap.drawRectangle(0, 0, width, height);
        return pixmap;
    }
    public void update(float deltaTime) {
        handleDebugInput(deltaTime);
        updateTestObjects(deltaTime);
    }
    private void handleDebugInput(float deltaTime) {
        if (Gdx.app.getType() != Application.ApplicationType.Desktop)
            return;
        float sprMoveSpeed = 2 * deltaTime;
        if (Gdx.input.isKeyPressed(Input.Keys.A))
            moveSelectedSprite(-sprMoveSpeed, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            moveSelectedSprite(sprMoveSpeed, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.W))
            moveSelectedSprite(0, sprMoveSpeed);
        if (Gdx.input.isKeyPressed(Input.Keys.S))
            moveSelectedSprite(0, -sprMoveSpeed);
    }
    private void moveSelectedSprite(float x, float y) {
        testSprites[selectedSprite].translate(x, y);
    }
    private void updateTestObjects(float deltaTime) {
        float rotation = testSprites[selectedSprite].getRotation();
        rotation += 90 * deltaTime;
        rotation %= 360;
        testSprites[selectedSprite].setRotation(rotation);
    }
}





