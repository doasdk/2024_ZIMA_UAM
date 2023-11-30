// ******************************************************************
//
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//
// ******************************************************************

package pl.psi;

import lombok.Value;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
@Value
public class Point {
    private final int x;
    private final int y;

    double distance(Point aPoint){
        return x - aPoint.getX();
    }
}
