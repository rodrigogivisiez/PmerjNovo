package br.gov.rj.arquivo.util.other;

/**
 * A linear layout that will contain views taken from an adapter. It differs
 * from the list view in the fact that it will not optimize anything and
 * draw all the views from the adapter. It also does not provide scrolling.
 * However, when you need a layout that will render views horizontally and
 * you know there are not many child views, this is a good option.

 *
 * @author Vincent Mimoun-Prat @ MarvinLabs
 */


public class AdapterLinearLayout{
        //extends LinearLayout {

//    private RecyclerView.Adapter adapter;
//    private DataSetObserver dataSetObserver = new DataSetObserver() {
//        @Override
//        public void onChanged() {
//            super.onChanged();
//            reloadChildViews();
//        }
//    };
//
//    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
//    public AdapterLinearLayout(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        setOrientation(LinearLayout.HORIZONTAL);
//    }
//
//    public AdapterLinearLayout(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        setOrientation(LinearLayout.HORIZONTAL);
//    }
//
//    public AdapterLinearLayout(Context context) {
//        super(context);
//        setOrientation(LinearLayout.HORIZONTAL);
//    }
//
//    public void setAdapter(RecyclerView.Adapter adapter) {
//        if (this.adapter == adapter) return;
//        this.adapter = adapter;
//        if (adapter != null) adapter.registerDataSetObserver(dataSetObserver);
//        reloadChildViews();
//    }
//
//    @Override
//    protected void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//      //  if (adapter != null) adapter.unregisterDataSetObserver(dataSetObserver);
//    }
//
//    private void reloadChildViews() {
//        removeAllViews();
//
//        if (adapter == null) return;
//
//       // int count = adapter.getCount();
//      //  for (int position = 0; position < count; ++position) {
//       //     View v = adapter.getView(position, null, this);
//       //     if (v != null) addView(v);
//        }
//
//        requestLayout();
//    }
}



