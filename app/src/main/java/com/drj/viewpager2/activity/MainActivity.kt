package com.drj.viewpager2.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.drj.viewpager2.R
import com.drj.viewpager2.adapter.ViewPagerAdapter
import com.drj.viewpager2.model.IntroSlide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val introSlide = ViewPagerAdapter(
        this,
        listOf(
            IntroSlide(
                "Run",
                "“I breathe in strength and breathe out weakness.”",
                R.drawable.run
            ),
            IntroSlide(
                "Business",
                "“I don’t know the word ‘quit.’ Either I never did, or I have abolished it.”",
                R.drawable.business
            ),
            IntroSlide("Life",
                " “Your time is limited, so don’t waste it living someone else’s life. Don’t be trapped by dogma – which is living with the results of other people’s thinking.”",
                R.drawable.time
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = introSlide

        /* TabLayoutMediator(tabLayout, viewPager) { name, positions ->
           name.text = "Tab ${positions + 1}"
           }.attach()
          */
        setupIndicator()
        setCurrentIndicator(0)

        btn_next.setOnClickListener {
            if (viewPager.currentItem + 1 < introSlide.itemCount) {
                viewPager.currentItem += 1
            } else {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
                finish()
            }
        }

        tv_skip.setOnClickListener {
            startActivity(Intent(applicationContext, HomeActivity::class.java))
            finish()
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
    }

    private fun setupIndicator() {
        val indicator = arrayOfNulls<ImageView>(introSlide.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            WRAP_CONTENT,
            WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicator.indices) {
            indicator[i] = ImageView(applicationContext)
            indicator[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext, R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            indicatorLayout.addView(indicator[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = indicatorLayout.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorLayout[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext, R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext, R.drawable.indicator_inactive
                    )
                )
            }
        }
    }


}