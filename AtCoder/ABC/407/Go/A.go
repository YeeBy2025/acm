package main

import "fmt"

func main() {
	var a, b int
	_, _ = fmt.Scanf("%d %d", &a, &b)
	c := a / b
	a = a % b
	if a*2 > b {
		fmt.Print(c + 1)
	} else {
		fmt.Print(c)
	}
}
