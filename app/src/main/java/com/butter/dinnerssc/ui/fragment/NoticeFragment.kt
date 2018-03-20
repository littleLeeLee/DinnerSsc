package layout

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.butter.dinnerssc.R
import com.butter.dinnerssc.model.event.InitDataEvent
import com.butter.dinnerssc.model.event.SwitchLotteryEvent
import com.butter.dinnerssc.ui.activity.NoticeActivity
import com.butter.dinnerssc.ui.fragment.BaseFragment
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import kotlinx.android.synthetic.main.fragment_notice.view.*
/**
 * Created by gangoogle on 2018/3/19.
 */
class NoticeFragment : BaseFragment(){
    override fun initViewData() {
    }

    override fun setClick(view: View?) {
        view?.setOnClickListener { startActivity(Intent(context,NoticeActivity::class.java)) }
    }

    init {
        EventBus.getDefault().register(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        EventBus.getDefault().unregister(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_notice, container, false)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun recvInitDataEvent(event: InitDataEvent) {
        initData()
    }

    fun initData(){
        mView?.ll_notice?.visibility=View.VISIBLE
    }
}