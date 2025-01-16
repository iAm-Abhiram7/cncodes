// import java.util.Scanner;

// public class dvr {
//     static final int INF = 9999; // Constant to represent infinity

//     // Function to print the routing table for each node
//     static void printRoutingTable(int numNodes, int[][] distVector, int[][] nextHop) {
//         for (int i = 0; i < numNodes; i++) {
//             System.out.println("Routing table for node " + i + ":");
//             System.out.println("Destination\tNext Hop\tDistance");
//             for (int j = 0; j < numNodes; j++) {
//                 if (distVector[i][j] == INF) {
//                     System.out.println(j + "\t\t-\t\tINF");
//                 } else {
//                     System.out.println( j + "\t\t" + (nextHop[i][j] == -1 ? "-" : nextHop[i][j]) + "\t\t" + distVector[i][j]);
//                 }
//             }
//             System.out.println();
//         }
//     }

//     // Distance Vector Routing Algorithm
//     static void distanceVectorRouting(int n, int[][] distanceVec, int[][] nextHop) {
//         boolean updated;
//         do {
//             updated = false;
//             for (int i = 0; i < n; i++) {
//                 for (int j = 0; j < n; j++) {
//                     for (int k = 0; k < n; k++) {
//                         // Relaxation step
//                         if (distanceVec[i][k] != INF && distanceVec[k][j] != INF
//                                 && distanceVec[i][k] + distanceVec[k][j] < distanceVec[i][j]) {
//                             distanceVec[i][j] = distanceVec[i][k] + distanceVec[k][j];
//                             nextHop[i][j] = nextHop[i][k];
//                             updated = true; // Mark as updated
//                         }
//                     }
//                 }
//             }
//         } while (updated);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         // Input number of nodes
//         System.out.print("Enter the number of nodes: ");
//         int n = sc.nextInt();

//         int[][] costMat = new int[n][n]; // Cost matrix
//         int[][] distanceVec = new int[n][n]; // Distance vector table
//         int[][] nextHop = new int[n][n]; // Next hop table

//         // Input cost matrix
//         System.out.println("Enter the cost matrix (use " + INF + " for infinity):");
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 costMat[i][j] = sc.nextInt();
//             }
//         }

//         // Initialize distanceVec and nextHop
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 distanceVec[i][j] = costMat[i][j]; // Copy cost matrix to distance vector
//                 nextHop[i][j] = (costMat[i][j] != INF && i != j) ? j : -1; // Set next hop
//             }
//         }

//         // Apply Distance Vector Routing Algorithm
//         distanceVectorRouting(n, distanceVec, nextHop);

//         // Print the routing table for each node
//         printRoutingTable(n, distanceVec, nextHop);

//         sc.close();
//     }
// }










import java.util.*;
public class dvr{
    static int INF = 9999;

    static void printTable(int n, int[][] distVec, int[][] nextHop){
        for(int i=0;i<n;i++){
            System.out.println("The routing table for node : " + i);
            System.out.println("Destination \tNext-Hop \tDistance");
            for(int j=0;j<n;j++){
                if(distVec[i][j] != INF){
                    System.out.println(j + "\t\t" + (nextHop[i][j] == -1 ? " - " : nextHop[i][j] )+ "\t\t" + distVec[i][j]);
                }else{
                    System.out.println(j + "\t\t" + " - " + "\t\t" + INF);
                }
            }
        }
    }

    static void dvrTable(int n, int[][] distVec, int[][] nextHop){
        boolean flag;
        do{
            flag = false;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int k=0;k<n;k++){
                        if(distVec[i][k] != INF && distVec[k][j] != INF && distVec[i][k] + distVec[k][j] < distVec[i][j]){
                            distVec[i][j] = distVec[i][k] + distVec[k][j];
                            nextHop[i][j] = nextHop[i][k];
                            flag = true;
                        }
                    }
                }
            }
        }while(flag);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] distVec = new int[n][n];
        int[][] nextHop = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distVec[i][j] = arr[i][j];
                nextHop[i][j] = (arr[i][j] != INF && i!=j) ? arr[i][j] : -1;
            }
        }

    }
}