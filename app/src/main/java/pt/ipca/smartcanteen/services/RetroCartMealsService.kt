package pt.ipca.smartcanteen.services

import pt.ipca.smartcanteen.models.RetroCartMeals
import pt.ipca.smartcanteen.models.RetroProfile
import pt.ipca.smartcanteen.models.RetroTicket
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface RetroCartMealsService {
    @GET("/api/v1/consumer/cart/meals")
    fun getMealsCart(@Header("Authorization") authorization: String): Call<List<RetroCartMeals>>

}