package com.example.ai_plus

import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.ai_plus.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // 멤버 변수로 ActivityMainBinding 객체의 변수를 선언
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 바인딩 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        // 2. 레이아웃(root뷰) 표시
        setContentView(binding.root)

        /*val cameraBtn = findViewById<Button>(R.id.upload) as Button
        cameraBtn.setOnClickListener(View.OnClickListener {
            val PERMISSION_CAMERA = 100
            requirePermissions(arrayOf(Manifest.permission.CAMERA), PERMISSION_CAMERA)

        })*/

        //버튼 이벤트
        binding.upload2.setOnClickListener {
            // 갤러리 호출
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*" // 이미지 전체 가져오기
            activityResult.launch(intent)
        }
    }

    // 외부 활동에 무언가를 요청하고 요청한 것에 대한 결과를 받는 양방향 작업
    private val activityResult: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){

        // resultCode로 사진을 정상적으로 선택하였다면 RESULT_OK 값이 넘어옴
        // 결과 코드 ok거나 결과값이 null 아니면
        if(it.resultCode == RESULT_OK && it.data != null){
            // 값 담기
            val uri = it.data!!.data

            // 화면에 보여주기
            Glide.with(this)
                .load(uri) //이미지
                .into(binding.cameraimage) // 보여줄 위치
        }
    }



    // result 누르면 DetectedActivity로 넘어감
    fun onResultbtnClicked(v: View?) {
        val intent = Intent(this@MainActivity, DetectedActivity::class.java)
        startActivity(intent)
    }



}






