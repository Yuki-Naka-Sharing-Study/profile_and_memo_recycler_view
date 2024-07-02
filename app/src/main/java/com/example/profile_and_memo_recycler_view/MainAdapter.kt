package com.example.profile_and_memo_recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.profile_and_memo_recycler_view.databinding.ItemEditTextWithoutImageViewBinding
import com.example.profile_and_memo_recycler_view.databinding.ItemTextViewWithImageViewBinding
import com.example.profile_and_memo_recycler_view.databinding.ItemTextViewWithoutImageViewBinding

const val ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW = 0
const val ITEM_TEXT_VIEW_WITH_IMAGE_VIEW = 1
const val ITEM_EDIT_TEXT_WITHOUT_IMAGE_VIEW = 2

class MainAdapter(private val mList: List<DataItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ItemTextViewWithoutImageViewHolder(private val binding: ItemTextViewWithoutImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindTextViewWithoutImageView(dataItem: DataItem) {
            binding.profileTextView.text = dataItem.profileTextViewString
            binding.profileEditText.setText(dataItem.profileEditTextString)
        }
    }

    inner class ItemTextViewWithImageViewHolder(private val binding: ItemTextViewWithImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindTextViewWithImageView(dataItem: DataItem) {
            binding.profileTextView.text = dataItem.profileTextViewString
            binding.profileEditText.setText(dataItem.profileEditTextString)
            dataItem.profileImageViewInt?.let { binding.profileImageView.setImageResource(it) }
        }
    }

    inner class ItemEditTextWithoutImageViewHolder(private val binding: ItemEditTextWithoutImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindEditTextWithoutImageView(dataItem: DataItem) {
            binding.customProfileEditText.text = dataItem.profileCustomEditTextString
            binding.profileEditText.setText(dataItem.profileEditTextString)
        }
    }

    override fun getItemViewType(position: Int): Int {

        if (mList[position].profileTextViewString != null) {
            return ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW
        } else if (mList[position].profileImageViewInt != null) {
            return ITEM_TEXT_VIEW_WITH_IMAGE_VIEW
        } else {
            return ITEM_EDIT_TEXT_WITHOUT_IMAGE_VIEW
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW) {
            val binding = ItemTextViewWithoutImageViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemTextViewWithoutImageViewHolder(binding)

        } else if (viewType == ITEM_TEXT_VIEW_WITH_IMAGE_VIEW){
            val binding = ItemTextViewWithImageViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemTextViewWithImageViewHolder(binding)

//        } else if (viewType == ITEM_EDIT_TEXT_WITHOUT_IMAGE_VIEW){

        } else {
            val binding = ItemEditTextWithoutImageViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemEditTextWithoutImageViewHolder(binding)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW) {

            (holder as ItemTextViewWithoutImageViewHolder).bindTextViewWithoutImageView(mList[position])

        } else if (getItemViewType(position) == ITEM_TEXT_VIEW_WITH_IMAGE_VIEW) {

            (holder as ItemTextViewWithImageViewHolder).bindTextViewWithImageView(mList[position])

        } else if (getItemViewType(position) == ITEM_EDIT_TEXT_WITHOUT_IMAGE_VIEW) {

            (holder as ItemEditTextWithoutImageViewHolder).bindEditTextWithoutImageView(mList[position])

        }
    }
}