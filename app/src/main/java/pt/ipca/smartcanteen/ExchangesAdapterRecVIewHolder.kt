package pt.ipca.smartcanteen

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExchangesAdapterRecVIewHolder(inflater: LayoutInflater, val parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.my_exchange_card, parent, false)){
    val nameTv = itemView.findViewById<TextView>(R.id.my_exchanges_card_name)
    val quantityTv = itemView.findViewById<TextView>(R.id.my_exchanges_card_quantity)
    val priceTv = itemView.findViewById<TextView>(R.id.my_exchanges_card_price)
    val stateTv = itemView.findViewById<TextView>(R.id.my_exchanges_card_state)

    fun bindData(nameText:String, quantityText: String, priceText:String, stateText: String){
        nameTv.text=nameText
        quantityTv.text = quantityText
        priceTv.text=priceText
        stateTv.text=stateText
    }
}