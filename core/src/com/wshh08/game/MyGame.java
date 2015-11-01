package com.wshh08.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.wshh08.game.controller.WorldController;
import com.wshh08.game.view.WorldRenderer;

public class MyGame extends ApplicationAdapter {
	private static final String TAG = MyGame.class.getName();
	private WorldController worldController;
	private WorldRenderer worldRenderer;
	private boolean paused;

	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
//		controller及renderer应该以模型World对象实例作为参数.
		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);
		paused = false;
	}

	@Override
	public void render () {
		if (!paused)
			worldController.update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(0x64 / 255.0f, 0x95 / 255.0f, 0xed / 255.0f,0xff / 255.0f);
//		Gdx.gl.glClearColor(100/255.0f, 149/255.0f, 237/255.0f, 255/255.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		调用WorldRenderer的render函数描绘游戏世界.
		worldRenderer.render();
	}

	@Override
	public void resize(int width, int height) {
		worldRenderer.resize(width, height);

	}

	@Override
	public void pause() {
		paused = true;
	}

	@Override
	public void resume() {
		paused = false;
	}

	@Override
	public void dispose() {
		worldRenderer.dispose();
	}
}
