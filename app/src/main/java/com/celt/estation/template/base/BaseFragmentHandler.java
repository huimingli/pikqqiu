package com.celt.estation.template.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.celt.estation.template.AppVariable;
import com.celt.estation.template.utils.AppUtil;


/**
 * 继承Handler类，重写handleMessage方法
 * @author Administrator
 *
 */
public class BaseFragmentHandler extends Handler {
	protected BaseFragment fragment;
	protected BaseActivity ui;
	
	/**
	 * 如果是在Fragment界面里要调用Activity访问网络得到数据并回调到Fragment的话，就要传入当前Fragment对象
	 * @param ui
	 * @param fragment
	 */
	public BaseFragmentHandler (BaseActivity ui, BaseFragment fragment){
		this.ui = ui;
		this.fragment = fragment;
	}
	
	public BaseFragmentHandler (Looper looper) {
		super(looper);
	}
	
	@Override
	public void handleMessage(Message msg) {
		try {
			int taskId;
			String result;
			switch (msg.what) {
				case BaseTask.TASK_COMPLETE:
					ui.hideLoadBar();
					taskId = msg.getData().getInt("task");
					result = msg.getData().getString("data");
					if (result != null) {
						BaseMessage message = AppUtil.getMessage(result);
						fragment.onTaskComplete(taskId, message);
					} else if (!AppUtil.isEmptyInt(taskId)) {
						fragment.onTaskComplete(taskId);
					} else {
						ui.showToast(AppVariable.err.message);
					}
					break;
				case BaseTask.NETWORK_ERROR:
					ui.hideLoadBar();
					taskId = msg.getData().getInt("task");
					ui.onNetworkError(taskId);
					break;
				case BaseTask.SHOW_LOADBAR:
					ui.showLoadBar();
					break;
				case BaseTask.HIDE_LOADBAR:
					ui.hideLoadBar();
					break;
				case BaseTask.SHOW_TOAST:
					ui.hideLoadBar();
					result = msg.getData().getString("data");
					ui.showToast(result);
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			ui.showToast(e.getMessage());
		}
	}
	
}