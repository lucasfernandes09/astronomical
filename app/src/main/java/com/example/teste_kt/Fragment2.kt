package com.example.teste_kt

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_2.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.time.LocalDate

class Fragment2 : Fragment() {

    val data = LocalDate.now().toString()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)

        callImgDia(view)

        return view
    }

    fun callImgDia(view: View) {
        val service = RetrofitService.retrofit.create(RetrofitService::class.java)
        val request = service.recuperarImgDia(data)

        request.enqueue( object: Callback<ImgDia> {
            override fun onFailure(call: Call<ImgDia>, t: Throwable) {
                Log.i("infoF", "onFailure: " + t.message)
            }

            override fun onResponse(call: Call<ImgDia>, response: Response<ImgDia>) {
                if(response.isSuccessful) {
                    val imgDia: ImgDia? = response.body()
                    Picasso.get().load(imgDia?.url).resize(512, 360).into(view.iv_id)
                    view.progressBar.visibility = View.GONE
                    view.tv_title.text = imgDia?.title
                    view.tv_cr.text = imgDia?.copyright
                    view.tv_data.text = data
                }else {
                    Log.i("infoF", "onResponse: " + response.message())
                }
            }
        })
    }

}