package com.example.sampleballapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentViewで表示するViewファイルを設定している
        //setContentView(R.layout.activity_main)　<-デフォルトはxmlになっている

        // Viewの表示をクラスで表示する
        val ballView = BallView(this)
        setContentView(ballView)

    }

    // 1.class作成(Viewを作るのでViewを継承)
    // 2.constructerを作る必要がある(context: Context?)　<-ViewClassを継承するサブクラス
    class BallView(context: Context?) : View(context) {
        // paint:Paint => Paint型をpaintに代入, circleX:Float => Float型をcircleXに代入
        private var paint:Paint = Paint()
        private var circleX:Float = 200F
        private var circleY:Float = 200F

        // onDrawで描画の準備
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            canvas?.drawColor(Color.RED) // カンバスの色

            // ペイントする色の指定と丸い図形
            paint.color = Color.YELLOW
            canvas?.drawCircle(circleX,circleY,50F, paint)
        }

        // 画面タッチ
        override fun onTouchEvent(event: MotionEvent?): Boolean {
            // タッチポジション
            circleX = event!!.x
            circleY = event.y
            invalidate() // 値を常に更新し続ける場合にこれを記載する　

            // return super.onTouchEvent(event)
            return true // 常に処理をし続ける場合はreturn trueにしないとタッチしたままの移動ができない
        }
    }
}