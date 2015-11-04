package com.wshh08.game.view;

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
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (Sprite sprite : worldController.testSprites)
            sprite.draw(batch);
        batch.end();
    }
    public void resize(int width, int height) {
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
        camera.update();
    }
    @Override
    public void dispose() {
        batch.dispose();
    }
}
