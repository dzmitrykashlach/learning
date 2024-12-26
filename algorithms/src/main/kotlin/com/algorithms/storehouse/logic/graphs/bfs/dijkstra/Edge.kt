package com.algorithms.storehouse.logic.graphs.bfs.dijkstra

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import lombok.ToString

@AllArgsConstructor
@Getter
@Setter
@ToString
class Edge constructor(
    var weight:Double = 0.0,
    //    private Vertex startVertex;
    var targetDijkstraVertex: DijkstraVertex? = null
)