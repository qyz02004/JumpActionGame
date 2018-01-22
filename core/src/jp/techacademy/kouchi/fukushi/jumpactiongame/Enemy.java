package jp.techacademy.kouchi.fukushi.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Enemy extends GameObject {
    // 横幅、高さ
    public static final float ENEMY_WIDTH = 1.0f;
    public static final float ENEMY_HEIGHT = 1.0f;

    // 速度
    public static final float ENEMY_VELOCITY = 2.0f;

    float mX;
    float mY;
    Random mRandom;

    public Enemy( Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
        mRandom = new Random();
        double deg = mRandom.nextDouble() * 2 * Math.PI;
        velocity.x = (float) (ENEMY_VELOCITY * Math.sin(deg));
        velocity.y = (float) (ENEMY_VELOCITY * Math.cos(deg));
    }
    @Override
    public void setPosition (float x, float y) {
        super.setPosition(x,y);
        mX = x;
        mY = y;
    }

    // 座標を更新する
    public void update(float deltaTime) {
        float x = getX() + velocity.x * deltaTime;

        if (x > GameScreen.CAMERA_WIDTH - ENEMY_WIDTH ) {
            x = GameScreen.CAMERA_WIDTH - ENEMY_WIDTH;
            velocity.x = -velocity.x;
        }
        else if ( x < 0 ) {
            x = 0;
            velocity.x = -velocity.x;
        }
        setX(x);

        float y = getY() + velocity.y * deltaTime;
        if (y > mY + GameScreen.CAMERA_HEIGHT - ENEMY_HEIGHT) {
            velocity.y = -velocity.y;
        }
        else if ( y < mY ) {
            velocity.y = -velocity.y;
        }
        setY(y);
    }
}