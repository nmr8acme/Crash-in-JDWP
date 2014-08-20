package com.example.nathan.honestlywhothrowsashoe;

import android.app.Activity;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.os.Bundle;

public class Honestly extends Activity {
    private Path currentPath;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        honestly(new Point(1234, 314159));
    }

    private void honestly(Point point) {
        float blah = point.x;
        float bleh = point.y;
        currentPath = new Path();
        currentPath.setFillType(Path.FillType.WINDING);
        currentPath.moveTo(blah, bleh);
        whoThrowsAShoe();
    }

    private void whoThrowsAShoe() {
        PathMeasure pathMeasure = new PathMeasure(currentPath, false);
        float[] curPos = new float[2];
        boolean posTan = pathMeasure.getPosTan(pathMeasure.getLength(), curPos, null);
        if (!posTan) throw new AssertionError(); // breakpoint here

        // once the breakpoint is hit evaluate `pathMeasure.getLength()`
        // and then switch up one stack frame, observe crash in JDWP
    }
}
