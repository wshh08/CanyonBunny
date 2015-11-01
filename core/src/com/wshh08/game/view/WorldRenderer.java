package com.wshh08.game.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.wshh08.game.controller.WorldController;

/**
 * Created by wshh08 on 15-11-1.
 */
public class WorldRenderer implements Disposable {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private WorldController worldController;

    public WorldRenderer(WorldController worldController) {}
    public void init() {}
    public void render() {}
    public void resize(int width, int height) {}
    @Override
    public void dispose() {}
}
