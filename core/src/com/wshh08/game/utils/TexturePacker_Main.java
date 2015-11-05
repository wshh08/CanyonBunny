package com.wshh08.game.utils;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

/**
 * Created by wshh08 on 15-11-6.
 */
public class TexturePacker_Main {
    public static void main(String[] args) {
        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.maxWidth = 1024;
        settings.maxHeight = 1024;
        settings.debug = true; /*在atlas中显示红色分区边框*/
        TexturePacker.process(settings, "./android/assets/images_raw", "./android/assets/images", "canyonbunny");
    }
}
