package main

func numIdenticalPairs(nums []int) (ans int) {
	cnt := map[int]int{}
	for _, x := range nums {
		ans += cnt[x]
		cnt[x]++
	}
	return
}

func main() {
	numIdenticalPairs([]int{1, 2, 3, 1, 1, 3})
}
