package kaizhi.play24;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends Activity implements View.OnTouchListener, View.OnDragListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.txv_first).setOnTouchListener(this);
        findViewById(R.id.txv_second).setOnTouchListener(this);
        findViewById(R.id.txv_third).setOnTouchListener(this);
        findViewById(R.id.txv_fourth).setOnTouchListener(this);

        findViewById(R.id.txv_plus).setOnDragListener(this);
        findViewById(R.id.txv_minus).setOnDragListener(this);
        findViewById(R.id.txv_multiply).setOnDragListener(this);
        findViewById(R.id.txv_divide).setOnDragListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        final int dragEvent = event.getAction();
        Log.i("test", "on drag action: " + dragEvent);
        switch (dragEvent) {
            case DragEvent.ACTION_DRAG_ENTERED:
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DROP:
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                View view = (View) event.getLocalState();
                view.setVisibility(View.VISIBLE);
                break;
        }

        /*
        if (event.getAction()==DragEvent.ACTION_DROP) {
            View view = (View) event.getLocalState();
            ViewGroup from = (ViewGroup) view.getParent();
            from.removeView(view);
            LinearLayout to = (LinearLayout) v;
            to.addView(view);
            view.setVisibility(View.VISIBLE);
        }
        */
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int motionEvent = event.getAction();
        Log.i("test", "on touch action: " + motionEvent);
        switch (motionEvent) {
            case MotionEvent.ACTION_DOWN:
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(null, shadowBuilder, v, 0);
                v.setVisibility(View.INVISIBLE);
                break;
            case MotionEvent.ACTION_UP:
                v.setVisibility(View.VISIBLE);
                break;
            default:
                return false;
        }
        return true;
    }
}
