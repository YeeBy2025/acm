package main

import "fmt"

func main() {
	var a string
	_, err := fmt.Scanln(&a)
	if err != nil {
		return
	}
	sum := 1
	flag := false
	for _, runeChar := range a {
		if runeChar == '-' {
			sum -= 1
		}
		if runeChar == '*' {
			sum *= 2
		}
		if sum >= 2025 {
			flag = true
		}
	}
	if flag {
		fmt.Println("YES")
	} else {
		fmt.Println("NO")
	}
}
