package com.jtcxw.glcxw.listeners;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class ItemTouchCallBack extends ItemTouchHelper.Callback {
    private static final String TAG = "drag";
    private OnItemTouchListener onItemTouchListener;

    public void setOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.onItemTouchListener = onItemTouchListener;
    }

    /**
     * 根据 RecyclerView 不同的布局管理器，设置不同的滑动、拖动方向
     * 该方法使用 makeMovementFlags(int dragFlags, int swipeFlags) 方法返回
     * 参数: dragFlags:拖动的方向
     *      swipeFlags:滑动的方向
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager ||
                recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager){
            //此处不需要进行滑动操作，可设置为除4和8之外的整数，这里设为0
            //不支持滑动
            return makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                    ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, 0 );
        }else {
            //如果是LinearLayoutManager则只能向上向下滑动，
            //此处第二个参数设置支持向右滑动
            return makeMovementFlags(ItemTouchHelper.UP   | ItemTouchHelper.DOWN , ItemTouchHelper.RIGHT );
        }
    }

    /**
     * 当 ItemTouchHelper 拖动一个Item时该方法将会被回调，Item将从旧的位置移动到新的位置
     * 如果不拖动这个方法将从来不会调用,返回true表示已经被移动到新的位置
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();
        int toPosition   = target.getAdapterPosition();
        onItemTouchListener.onMove(fromPosition,toPosition);
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }


    /**
     * 当Item被滑动、拖动的时候被调用
     * @param viewHolder
     * @param actionState
     */
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        //...
        super.onSelectedChanged(viewHolder, actionState);
    }

    /**
     * 当与用户交互结束或相关动画完成之后被调用
     * @param recyclerView
     * @param viewHolder
     */
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
    }

    /**
     * 移动交换数据的更新监听
     */
    public interface OnItemTouchListener {
        //拖动Item时调用
        void onMove(int fromPosition, int toPosition);
        //滑动Item时调用
        void onSwiped(int position);
    }
}