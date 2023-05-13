package com.aayar94.valorantguidestats.ui.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aayar94.valorantguidestats.data.models.game_content.Agent
import com.aayar94.valorantguidestats.databinding.RowLayoutAgentsBinding
import com.aayar94.valorantguidestats.util.Constants.Companion.GlideImageLoader

class AgentsAdapter(val onItemClick: (agent: Agent) -> Unit) :
    RecyclerView.Adapter<AgentsAdapter.AgentsViewHolder>() {
    private var agentsList: MutableList<Agent> = mutableListOf()


    inner class AgentsViewHolder(private val binding: RowLayoutAgentsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            GlideImageLoader(binding.root.context,agentsList[position].displayIcon,binding.carouselImageView)

            binding.tvAgentName.text = agentsList[position].displayName
            binding.root.setOnClickListener {
                onItemClick(agentsList[position])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentsViewHolder {
        val binding =
            RowLayoutAgentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AgentsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return agentsList.size
    }

    override fun onBindViewHolder(holder: AgentsViewHolder, position: Int) {
        holder.bind(position)
    }

    fun setData(list: Array<Agent>?) {
        if (list != null) {
            agentsList.clear()
            for (i in list.indices) {
                if (list[i].uuid != "ded3520f-4264-bfed-162d-b080e2abccf9") {
                    agentsList.add(list[i])
                }
            }
        }
        this.notifyDataSetChanged()
    }
}