package pt.ipca.smartcanteen

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface BarMealsService {
    @GET("/api/v1/bar/{barId}/meals")
    fun getBarMeals(@Path("barId") barId: String, @Header("Authorization") authorization: String): Call<List<RetroMeal>>

}