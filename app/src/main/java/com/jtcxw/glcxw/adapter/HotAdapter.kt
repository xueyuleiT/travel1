package com.jtcxw.glcxw.adapter

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.glcxw.lib.util.AmountUtil
import com.jtcxw.glcxw.R
import com.jtcxw.glcxw.base.respmodels.ScenicBean
import com.jtcxw.glcxw.base.utils.DimensionUtil
import com.jtcxw.glcxw.base.views.recyclerview.BaseRecyclerAdapter
import com.jtcxw.glcxw.base.views.recyclerview.CommonRecyclerViewHolder
import com.jtcxw.glcxw.localbean.HotBean

class HotAdapter (context: Context, data: List<ScenicBean.ScenicInfoBean>) : BaseRecyclerAdapter<ScenicBean.ScenicInfoBean>(context, data) {
    override fun onClick(
        view: View?,
        model: ScenicBean.ScenicInfoBean?,
        position: Int,
        holder: CommonRecyclerViewHolder?
    ) {

    }

    override fun getConvertViewId(viewType: Int): Int {
        return R.layout.item_hot
    }

    override fun convert(holder: CommonRecyclerViewHolder?, data: ScenicBean.ScenicInfoBean?, position: Int) {
        val icon = holder!!.convertView.findViewById<ImageView>(R.id.icon)
        val desc = holder!!.convertView.findViewById<TextView>(R.id.tv_desc)
        val price = holder!!.convertView.findViewById<TextView>(R.id.tv_price)
        val tvSpotType = holder!!.convertView.findViewById<TextView>(R.id.tv_spot_type)

        if (!TextUtils.isEmpty(data!!.defaultPhotoUrl)) {
            Glide.with(icon)
                .load(data!!.defaultPhotoUrl)
                .into(icon)
        }
        desc.text = data!!.scenicName
        price.visibility = View.GONE
        tvSpotType.text = "景点"
//        price.text = "¥"+ AmountUtil.format(data!!.price.toDouble())
    }
}