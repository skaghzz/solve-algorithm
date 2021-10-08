class Solution {
    func distributeCandies(_ candyType: [Int]) -> Int {
        var set = Set<Int>()
        var n = candyType.count / 2
        for type in candyType {
            set.insert(type)
        }
        return set.count > n ? n : set.count
    }
}