package pt.svcdev.fragmentapp.view.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import pt.svcdev.fragmentapp.R

class ExamsAlertView : View {
    private var cardColor = Color.GRAY
    private var timerColor = Color.LTGRAY
    private val cardRect = RectF()
    private val timerRect = Rect()
    private var cardPaint = Paint()
    private var timerPaint = Paint()
    private var cardWidth = 0f
    private var cardHeight = 0f

    constructor(c: Context): super(c) {
        init()
    }

    constructor(c: Context, attrs: AttributeSet): super(c, attrs) {
        initAttrs(c, attrs)
        init()
    }

    constructor(c: Context, attrs: AttributeSet, defStyle: Int): super(c, attrs, defStyle) {
        initAttrs(c, attrs)
        init()
    }

    private fun initAttrs(c: Context, attrs: AttributeSet) {
        with(c.obtainStyledAttributes(attrs, R.styleable.ExamsActionView, 0, 0)) {
            cardColor = getColor(R.styleable.ExamsActionView_examsCard_Color, Color.GRAY)
            timerColor = getColor(R.styleable.ExamsActionView_timerCard_Color, Color.LTGRAY)
            recycle()
        }
    }

    private fun init() {
        cardPaint = Paint().run {
            color = cardColor
            style = Paint.Style.FILL
            this
        }
        timerPaint = Paint().run {
            color = timerColor
            style = Paint.Style.FILL
            this
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        cardWidth = w - paddingLeft.toFloat() - paddingRight.toFloat()
        cardHeight = h - paddingTop.toFloat() - paddingBottom.toFloat()
        cardRect.set(paddingLeft.toFloat(), paddingTop.toFloat(), cardWidth, cardHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        with(canvas) {
            drawRect(cardRect, cardPaint)
        }
    }
}