package com.gfdevs.lightingblocks.Services

import com.gfdevs.lightingblocks.Model.Level
import com.gfdevs.lightingblocks.Model.Move


object DataService {
//levels
    val levelLayouts = listOf(
        Level(0, listOf(0,1,5)),
        Level(1, listOf(11,13,15)),
        Level(2, listOf(1,2,6))
    )

    //move rules
    val moveRules = listOf(
        Move(0, listOf(0,1,5)),
        Move(1, listOf(0,1,2,6)),
        Move(2, listOf(1,2,3,7)),
        Move(3, listOf(2,3,4,8)),
        Move(4, listOf(3,4,9)),
        Move(5, listOf(0,5,6,10)),
        Move(6, listOf(1,5,6,7,11)),
        Move(7, listOf(2,6,7,8,12)),
        Move(8, listOf(3,7,8,9,13)),
        Move(9, listOf(4,8,9,14)),
        Move(10, listOf(5,10,11,15)),
        Move(11, listOf(6,10,11,12,16)),
        Move(12, listOf(7,11,12,13,17)),
        Move(13, listOf(8,12,13,14,18)),
        Move(14, listOf(9,13,14,19)),
        Move(15, listOf(10,15,16,20)),
        Move(16, listOf(11,15,16,17,21)),
        Move(17, listOf(12,16,17,18,22)),
        Move(18, listOf(13,17,18,19,23)),
        Move(19, listOf(14,18,19,24)),
        Move(20, listOf(15,20,21)),
        Move(21, listOf(16,20,21,22)),
        Move(22, listOf(17,21,22,23)),
        Move(23, listOf(18,22,23,24)),
        Move(24, listOf(19,23,24))
    )



}