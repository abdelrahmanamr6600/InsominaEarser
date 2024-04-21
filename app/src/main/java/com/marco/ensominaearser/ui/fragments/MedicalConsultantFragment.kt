package com.marco.ensominaearser.ui.fragments
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.marco.ensominaearser.R
import com.marco.ensominaearser.data.pojo.AiModelResponse
import com.marco.ensominaearser.data.remote.RetrofitInstance
import com.marco.ensominaearser.databinding.FragmentMedicalConsultantBinding
import io.github.muddz.styleabletoast.StyleableToast
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MedicalConsultantFragment : Fragment() {
    private lateinit var binding: FragmentMedicalConsultantBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMedicalConsultantBinding.inflate(layoutInflater)
setListeners()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return binding.root
    }

    private fun setListeners() {
        binding.checkBtn.setOnClickListener {
            binding.checkBtn.visibility = View.INVISIBLE
            binding.loadingGif.visibility = View.VISIBLE
            val requestBody: RequestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("Age", binding.ageTv.text.toString())
                .addFormDataPart("Sleep Duration", binding.SleepDurationTv.text.toString())
                .addFormDataPart("Quality of Sleep", binding.qualityOfSleepTv.text.toString())
                .addFormDataPart("Physical Activity Level", binding.activityTv.text.toString())
                .addFormDataPart("Stress Level", binding.stressLevelTv.text.toString())
                .addFormDataPart("BMI Category", binding.bmiTv.text.toString())
                .addFormDataPart("Heart Rate", binding.heartRateTv.text.toString())
                .addFormDataPart("Daily Steps", binding.dailyStepsTv.text.toString())
                .build()
            RetrofitInstance.api.getResult(requestBody).enqueue(object : Callback<AiModelResponse> {
                override fun onResponse(p0: Call<AiModelResponse>, p1: Response<AiModelResponse>) {
                    if (p1.isSuccessful){
                        binding.checkBtn.visibility = View.VISIBLE
                        binding.loadingGif.visibility = View.INVISIBLE
                        StyleableToast.makeText(requireContext(),p1.body()!!.prediction,Toast.LENGTH_LONG,
                            R.style.mytoast).show()
                    }

                }

                override fun onFailure(p0: Call<AiModelResponse>, p1: Throwable) {
                    Log.d("res", p1.message!!)
                }

            })

        }

    }
}