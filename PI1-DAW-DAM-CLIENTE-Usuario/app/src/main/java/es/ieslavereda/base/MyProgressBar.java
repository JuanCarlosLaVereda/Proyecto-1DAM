package es.ieslavereda.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

/**
 * Clase que extiende ProgressBar para proporcionar una barra de progreso personalizada y centrada en un ViewGroup específico.
 */
public class MyProgressBar extends ProgressBar {

    private ViewGroup rootView;

    public MyProgressBar(Context context) {
        super(context);
    }

    public MyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Inicializa la barra de progreso y la agrega al ViewGroup especificado.
     *
     * @param rootView El ViewGroup al que se agregará la barra de progreso.
     */
    public void initControl(ViewGroup rootView){
        this.rootView = rootView;
        center();
        this.rootView.addView(this);
    }

    /**
     * Muestra la barra de progreso y oculta los demás hijos del ViewGroup.
     */
    public void show(){

        for(int i = 0; i <rootView.getChildCount(); i++){
            View child = rootView.getChildAt(i);
            if(!child.equals(this))
                child.setVisibility(View.GONE);
            else
                child.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Oculta la barra de progreso y muestra los demás hijos del ViewGroup.
     */
    public void hide() {
        for (int i = 0; i < rootView.getChildCount(); i++) {
            View child = rootView.getChildAt(i);
            if (!child.equals(this))
                child.setVisibility(View.VISIBLE);
            else
                child.setVisibility(View.GONE);
        }
    }

    /**
     * Centra la barra de progreso en el ViewGroup.
     */
    public void center(){
        if (rootView instanceof ConstraintLayout) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams( ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.bottomToBottom = ConstraintSet.PARENT_ID;
            layoutParams.endToEnd = ConstraintSet.PARENT_ID;
            layoutParams.startToStart = ConstraintSet.PARENT_ID;
            layoutParams.topToTop = ConstraintSet.PARENT_ID;
            this.setLayoutParams(layoutParams);
        }
        else if(rootView instanceof RelativeLayout){
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams( RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
            this.setLayoutParams(layoutParams);
        }
    }

}
