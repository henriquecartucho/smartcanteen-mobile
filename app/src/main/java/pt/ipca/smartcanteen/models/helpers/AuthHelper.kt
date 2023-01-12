package pt.ipca.smartcanteen.models.helpers

import android.app.Activity
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import pt.ipca.smartcanteen.services.LoginService
import pt.ipca.smartcanteen.views.activities.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class AuthHelper {
    fun doLogout(
        retrofit: Retrofit,
        activity: Activity,
        loadingDialogManager:LoadingDialogManager
    ){
        val service = retrofit.create(LoginService::class.java)

        val sp = SharedPreferencesHelper.getSharedPreferences(activity)
        val token = sp.getString("token", null)

        loadingDialogManager.dialog.show()

        service.logout("Bearer $token").enqueue(object :
            Callback<String> {
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                if (response.code() == 200) {
                    sp.edit().remove("token").apply()
                    loadingDialogManager.dialog.dismiss()
                    var intent = Intent(activity, LoginActivity::class.java)
                    activity.finish()
                    startActivity(activity,intent,null)
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                print("error")
            }

        })
    }
}