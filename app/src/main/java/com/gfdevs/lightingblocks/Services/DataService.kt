package com.gfdevs.lightingblocks.Services

import com.gfdevs.lightingblocks.Model.Level
import com.gfdevs.lightingblocks.Model.Move


object DataService {
//levels
    val levelLayouts = listOf(
        Level(0, listOf(0,1,5)),
        Level(1, listOf(10,12,14)),
        Level(2, listOf(0,2,4,5,7,9,15,17,19,20,22,24)),
        Level(3, listOf(1,3,5,6,8,9,10,11,13,14,15,16,18,19,21,23)),
        Level(4, listOf(5,6,8,9,15,19,20,21,23,24)),
        Level(5, listOf(0,1,2,3,5,6,7,9,10,11,12,14,18,19,20,21,23,24)),
        Level(6, listOf(10,12,14,15,17,19,21,22,23)),
        Level(7, listOf(0,1,2,3,5,9,10,14,15,19,20,21,22,23)),
        Level(8, listOf(7,11,13,15,17,19,21,23)),
        Level(9, listOf(1,3,5,6,7,8,9,11,12,13,16,18,19,20,21,22)),
        Level(10, listOf(2,3,4,5,6,7,11,12,13)),
        Level(11, listOf(0,2,4,5,7,9,10,12,14,15,17,19,21,22,23)),
        Level(12, listOf(0,1,2,3,4,6,8,10,11,13,14,16,17,18,21,23)),
        Level(13, listOf(3,7,9,11,13,15,17,21)),
        Level(14, listOf(11,16,21)),
        Level(15, listOf(6,16)),
        Level(16, listOf(0,5,10,15,20,21,22,23,24)),
        Level(17, listOf(12,16,17,18,20,21,22,23,24)),
        Level(18, listOf(2,6,8,10,12,14,16,18,22)),
        Level(19, listOf(0,2,4,10,12,14,20,22,24)),
        Level(20, listOf(10,14)),
        Level(21, listOf(1,2,3,4,6,11,12,13,16,21)),
        Level(22, listOf(1,2,3,5,9,10,14,15,19,21,22,23))


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