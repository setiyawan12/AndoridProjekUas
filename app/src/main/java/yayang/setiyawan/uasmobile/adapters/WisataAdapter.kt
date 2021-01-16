package yayang.setiyawan.uasmobile.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import yayang.setiyawan.uasmobile.DetailActivity
import yayang.setiyawan.uasmobile.R
import yayang.setiyawan.uasmobile.models.Wisata
import kotlinx.android.synthetic.main.list_item.view.*

class WisataAdapter(private var data : List<Wisata>, private var context : Context) : RecyclerView.Adapter<WisataAdapter.MyHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        )
    }
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) = holder.bind(data[position],context)

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tourism: Wisata, context: Context){
            itemView.name.text = tourism.name
            itemView.location.text = tourism.location
            itemView.description.text = tourism.description
            itemView.setOnClickListener{
                context.startActivity(Intent(context,
                    DetailActivity::class.java).apply {
                    putExtra("wisata",tourism)
                })
            }
        }
    }
}

