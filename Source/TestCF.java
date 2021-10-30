package Source;

import CConsoleFunJNI.ConsoleFun;
import ConsoleFunJNI.CFOpts;

import Source.linkedList.List;
import Source.linkedList.Node;

public class TestCF {
    public static CFOpts DefOpts; // Default ConsoleFun Options to be used through out program

    public static void main(String[] args) {
        // Load ConsoleFun library;
        ConsoleFun.LoadLib("./ConsoleFun/ConsoleFunJNI");

        // Set default options
        // First Get Rows and Cols of screen;
        DefOpts = ConsoleFun.GetOpts();
        // By default, it also provides default Row and Col of the cursor;
        // set those to 0;
        DefOpts.Row = 0;
        DefOpts.Col = 0;
        // Set default colors to be used;
        // Default White text, Black bg;
        DefOpts.FG = ConsoleFun.Color.White;
        DefOpts.BG = ConsoleFun.Color.Black;
        // Now, clear screen, draw black box in entire screen
        ConsoleFun.FilledRect(DefOpts);

        // Draw Layout Frame: 1 + 2 columns
        CFOpts tempFrame = new CFOpts();
        tempFrame.Row = 0;
        tempFrame.Col = 0;
        tempFrame.Rows = DefOpts.Rows / 3;
        tempFrame.Cols = DefOpts.Cols;
        tempFrame.BG = ConsoleFun.Color.Blue;
        ConsoleFun.EmptyRect(tempFrame);
        tempFrame.Row = tempFrame.Rows - 1;
        tempFrame.Rows *= 2;
        ConsoleFun.EmptyRect(tempFrame);

    } // main
}