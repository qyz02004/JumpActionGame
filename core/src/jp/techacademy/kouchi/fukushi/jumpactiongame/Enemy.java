package jp.techacademy.kouchi.fukushi.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Enemy extends GameObject {
    // 横幅、高さ
    public static final float ENEMY_WIDTH = 2.0f;
    public static final float ENEMY_HEIGHT = 0.5f;

    // タイプ（垂直に動くタイプ）
    public static final int ENEMY_TYPE_VERTICAL = 0;

    // タイプ（水平に動くタイプ）
    public static final int ENEMY_TYPE_HORIZONTAL = 1;

    // 速度
    public static final float ENEMY_VELOCITY = 3.0f;

    int mType;
    int mState;
    float mX;
    float mY;
    Random mRandom;

    public Enemy(int type, Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
        mType = type;
        mRandom = new Random();
        if (mType == ENEMY_TYPE_HORIZONTAL) {
            velocity.x = ENEMY_VELOCITY;
        } else if ( mType == ENEMY_TYPE_VERTICAL ) {
            velocity.y = ENEMY_VELOCITY;
        }
    }
    @Override
    public void setPosition (float x, float y) {
        super.setPosition(x,y);
        mX = x;
        mY = y;
    }


    // 座標を更新する
    public void update(float deltaTime) {
        if (mType == ENEMY_TYPE_HORIZONTAL) {
            float x = getX() + velocity.x * deltaTime;
            setX(x);

            if (x > GameScreen.CAMERA_WIDTH + ENEMY_WIDTH / 2 ) {
                velocity.x = -velocity.x;
            }
            else if (x < - ENEMY_WIDTH / 2 ) {
                velocity.x = -velocity.x;
            }
        } else if ( mType == ENEMY_TYPE_VERTICAL ) {
            float y = getY()+ velocity.y * deltaTime;
            setY(y);
            if (y < mY - GameScreen.CAMERA_HEIGHT ) {
                velocity.y = -velocity.y;
            }
            else if (y > mY + GameScreen.CAMERA_HEIGHT ) {
                velocity.y = -velocity.y;
            }
        }

    }
}