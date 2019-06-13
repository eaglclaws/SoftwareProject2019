/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmtest;

/**
 *
 * @author SW교육지원팀
 */
public class FSM {
    State state[] = {new Neutral(), new Scan(), new DrawAdapter(), new Draw(), new TranslateAdapter(), new Translate(), new RotateAdapter(), new Rotate(), new ScaleAdapter(), new Scale(), new Select(), new Save()};
    /*
    ---States---
    Neutral | Scan | DrawAdapter | Draw | TranslateAdapter | Translate | RotateAdapter | Rotate | ScaleAdapter | Scale | Select | Save |
       0    |   1  |     2       |  3   |      4           |    5      |     6         |   7    |    8         |  9    |   10   |  11  |
    
    ---Messages---
    Press | Drag | Release | Nothing | Shape | TranslatePoint | RotatePoint | ScalePoint |
       0  |   1  |    2    |   3     |   4   |    5           |      6      |     7      |
    */
    //                        Neutral            Scan          DrawAdapter       Draw        TranslateAdapter     Translate       RotateAdapter       Rotate        ScaleAdapter       Scale                Select
    int[][] transition = {{1,0,0,0,0,0,0},{1,1,1,2,10,4,6,8},{2,3,0,2,2,2,2},{3,3,11,3,3,3,3},{4,5,10,4,4,4,4},{5,5,11,5,5,5,5},{6,7,10,6,6,6,6},{7,7,11,7,7,7,7},{8,9,10,8,8,8,8},{9,9,11,9,9,9,9},{1,11,11,11,11,11,11}};
    int current = 0;
    void next(int msg)
    {
        current = transition[current][msg];
    }
    public void go(int msg)
    {
        state[current].go(msg);
        next(msg);
    }
}

abstract class State
{
    public void press() {}
    public void drag() {}
    public void release() {}
    public void nothing() {}
    public void shape() {}
    public void translatePoint() {}
    public void rotatePoint() {}
    public void scalePoint() {}
    
    interface Transition {public void go();}
    
    Transition[] transition = new Transition[] {
        new Transition() {public void go() {press();}},
        new Transition() {public void go() {drag();}},
        new Transition() {public void go() {release();}},
        new Transition() {public void go() {nothing();}},
        new Transition() {public void go() {shape();}},
        new Transition() {public void go() {translatePoint();}},
        new Transition() {public void go() {rotatePoint();}},
        new Transition() {public void go() {scalePoint();}},
    };
    
    public void go(int msg)
    {
        transition[msg].go();
    }
}
