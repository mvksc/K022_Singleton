package m.vk.k022_singleton.singleton

import android.content.Context

class Contexttor private constructor(){
    private var context: Context? = null
    object Holder{
        val INSTANCE = Contexttor()
    }

    companion object{
        val INSTANCE: Contexttor by lazy { Holder.INSTANCE }
    }


    fun init(context: Context){
        this.context = context
    }

    fun clear(){
        this.context = null
    }
    fun getContext(): Context? {
        return context
    }
}