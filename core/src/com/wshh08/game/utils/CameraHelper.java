package com.wshh08.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by wshh08 on 15-11-5.
 */
public class CameraHelper {
    private static final String TAG = CameraHelper.class.getName();
    private final float MAX_ZOOM_IN = 0.25f;
    private final float MAX_ZOOM_OUT = 10.0f;
    private Vector2 position;
    private float zoom;
    private Sprite target;
    boolean targetChanged = false;

    public CameraHelper() {
        position = new Vector2(2.5f, 2.5f);
        zoom = 1.0f;
    }
    public void update(float deltaTime) {
        if(!hasTarget()){
//            Gdx.app.debug(TAG, "Has no target, Camera position is not updated, deltaTime = " + deltaTime);
            return;
        }
        if (targetChanged) {
            position.x = target.getX() + target.getOriginX();
            position.y = target.getY() + target.getOriginY();
            targetChanged = false;
//        Gdx.app.debug(TAG, "Has a target, camera position is updated ^o^, deltaTime = " + deltaTime);
        }
    }
    public void setPosition(float x, float y) {
        this.position.set(x, y);
    }
    public Vector2 getPosition() {
        return position;
    }
    public void addZoom(float amount) {
        setZoom(zoom + amount);
    }
    public void setZoom(float zoom) {
        this.zoom = MathUtils.clamp(zoom, MAX_ZOOM_IN, MAX_ZOOM_OUT);
    }
    public float getZoom() {
        return zoom;
    }
    public void setTarget(Sprite target) {
        this.target = target;
        targetChanged = true;
    }
    public Sprite getTarget() {
        return target;
    }
    public boolean hasTarget() {
        return target != null;
    }
    public boolean hasTarget(Sprite target) {
        return hasTarget() && this.target.equals(target);
    }
    public void applyTo(OrthographicCamera camera) {
        camera.position.x = position.x;
        camera.position.y = position.y;
        camera.zoom = zoom;
        camera.update();
        Gdx.app.debug("Camera", camera.position.toString() + camera.zoom);
    }
}
