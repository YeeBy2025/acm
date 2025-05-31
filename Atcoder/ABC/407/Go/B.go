package main

import (
	"fmt"
	"math"
)

func main() {
	var x, y int
	_, _ = fmt.Scanf("%d %d", &x, &y)
	cnt1 := 0
	cnt2 := 0
	cnt3 := 0
	for i := 1; i <= 6; i++ {
		for j := 1; j <= 6; j++ {
			if i+j >= x {
				cnt1++
			}
			if math.Abs(float64(i-j)) >= float64(y) {
				cnt2++
			}
			if i+j >= x && math.Abs(float64(i-j)) >= float64(y) {
				cnt3++
			}
		}
	}
	fmt.Printf("%.10f", float64(cnt1+cnt2-cnt3)/36.0)
}
