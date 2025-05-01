package main

import "fmt"

func main() {
	var length int
	_, err := fmt.Scanf("%d", &length)
	if err != nil {
		return
	}
	var a string
	_, err = fmt.Scanln(&a)
	if err != nil {
		return
	}
	sum := 0
	for i := 0; i < length-1; i++ {
		if a[i] == a[i+1] {
			sum++
		}
	}
	if sum > 1 {
		fmt.Println("NO")
	} else {
		fmt.Println("YES")
	}
}
