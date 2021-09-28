import Foundation

func solution(_ numbers:[Int], _ hand:String) -> String {
    var result = ""
    var cellPhone = [
        [4,2],[1,1],[1,2],[1,3],[2,1],
        [2,2],[2,3],[3,1],[3,2],[3,3],
        [4,1],[4,3],
    ]
    var leftHand = 10
    var rightHand = 11
    for number in numbers {
        if (number == 1 || number == 4 || number == 7) {
            result += "L"
            leftHand = number
        } else if (number == 3 || number == 6 || number == 9) {
            result += "R"
            rightHand = number
        } else {
            var leftDistance = abs(cellPhone[leftHand][0] - cellPhone[number][0]) + 
                abs(cellPhone[leftHand][1] - cellPhone[number][1])
            var rightDistance = abs(cellPhone[rightHand][0] - cellPhone[number][0]) + 
                abs(cellPhone[rightHand][1] - cellPhone[number][1])
            if (leftDistance == rightDistance) {
                if (hand == "left") {
                    result += "L"
                    leftHand = number
                } else {
                    result += "R"
                    rightHand = number
                }
            } else if (leftDistance > rightDistance) {
                result += "R"
                rightHand = number
            } else if (leftDistance < rightDistance) {
                result += "L"
                leftHand = number
            } 
        }
    }
    return result
}
