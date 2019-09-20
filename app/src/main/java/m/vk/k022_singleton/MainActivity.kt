package m.vk.k022_singleton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import m.vk.k022_singleton.databinding.ActivityMainBinding
import m.vk.k022_singleton.singleton.Helper

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.tvResult.text = "การเชื่อมต่ออินเตอร์เน็ต : ${Helper.INSTANCE.isConnectInternet()} \n\n\n " +
                "ขนาดหน้าจอ : ${Helper.INSTANCE.getScreenSizeWidth()} X ${Helper.INSTANCE.getScreenSizeHeight()} px"
    }
}
