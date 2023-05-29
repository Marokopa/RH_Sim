package com.mygdx.game;

import static com.mygdx.game.MyGdxGame.SCR_HEIGHT;
import static com.mygdx.game.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenIntro implements Screen {
    MyGdxGame mgg;

    Texture imgBackGround; // фоновое изображение

    TextButton btnPlay;
    TextButton btnSettings;
    TextButton btnAbout;
    TextButton btnExit;
    TextButton btnName;

    public ScreenIntro(MyGdxGame g) {
        mgg = g;

        imgBackGround = new Texture("Menu.jpg");
        btnName = new TextButton(mgg.font, "Robin Hood Simulator", 340, 690);
        btnPlay = new TextButton(mgg.font, "Play", 15, 480);
        btnSettings = new TextButton(mgg.font, "Settings", 15, 380);
        btnAbout = new TextButton(mgg.font, "About", 15, 280);
        btnExit = new TextButton(mgg.font, "Exit", 15, 180);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // касания экрана
        if(Gdx.input.justTouched()){
            mgg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            mgg.camera.unproject(mgg.touch);
            if(btnPlay.hit(mgg.touch.x, mgg.touch.y)){
                mgg.setScreen(mgg.screenGame);
            }
            if(btnSettings.hit(mgg.touch.x, mgg.touch.y)){
                mgg.setScreen(mgg.screenSettings);
            }
            if(btnAbout.hit(mgg.touch.x, mgg.touch.y)){
                mgg.setScreen(mgg.screenAbout);
            }
            if(btnExit.hit(mgg.touch.x, mgg.touch.y)){
                Gdx.app.exit();
            }
        }

        // события игры


        // вывод изображений
        mgg.camera.update();
        mgg.batch.setProjectionMatrix(mgg.camera.combined);
        mgg.batch.begin();
        mgg.batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnName.font.draw(mgg.batch, btnName.text, btnName.x, btnName.y);
        btnPlay.font.draw(mgg.batch, btnPlay.text, btnPlay.x, btnPlay.y);
        btnSettings.font.draw(mgg.batch, btnSettings.text, btnSettings.x, btnSettings.y);
        btnAbout.font.draw(mgg.batch, btnAbout.text, btnAbout.x, btnAbout.y);
        btnExit.font.draw(mgg.batch, btnExit.text, btnExit.x, btnExit.y);
        mgg.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        imgBackGround.dispose();
    }
}
