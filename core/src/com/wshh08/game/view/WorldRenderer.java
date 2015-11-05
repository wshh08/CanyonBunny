package com.wshh08.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.wshh08.game.controller.WorldController;
import com.wshh08.game.utils.Constants;

/**
 * Created by wshh08 on 15-11-1.
 */
public class WorldRenderer implements Disposable {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private WorldController worldController;

    public WorldRenderer(WorldController worldController) {
        this.worldController = worldController;
        init();
    }
    public void init() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH,
                Constants.VIEWPORT_HEIGHT);
        camera.position.set(2.5f, 2.5f, 0);
        camera.update();
    }
    public void render() {
        renderTestObjects();
    }
    public void renderTestObjects() {
        worldController.cameraHelper.applyTo(camera);
        Gdx.app.debug("Camera position", camera.position.toString() + camera.zoom);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (Sprite sprite : worldController.testSprites)
            sprite.draw(batch);
        batch.end();
    }
    public void resize(int width, int height) {
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;    /*实现横向镜头视野宽度根据屏幕分辨率变化(在纵向视野维持5个单位的前提下,保持画面比例)*/
        camera.update();
    }
    @Override
    public void dispose() {
        batch.dispose();
    }
}
