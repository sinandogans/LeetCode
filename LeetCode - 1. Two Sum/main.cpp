#include <iostream>
#include <vector>
#include <map>

using namespace std;

    vector<int> twoSum(vector<int>& nums, int target) {

        vector<int> output_indexes;
        map<int,int> numbers;
        int number1 = 0;
        int number2 = 0;
        int index_of_number1 = 0;

        for(int i = 0; i<nums.size();i++){
            if(numbers.find(nums[i]) != numbers.end()){
                numbers.erase(nums[i]);
                numbers.insert({nums[i],2});
            }
            else{
                numbers.insert({nums[i],1});
            }
        }

        for(int i = 0; i<nums.size();i++){
            int current_operand = nums[i];
            int required_operand = target-current_operand;
            if(required_operand != current_operand){
                if(numbers.find(required_operand) != numbers.end()){
                    number1 = current_operand;
                    number2 = required_operand;
                    index_of_number1 = i;
                    break;
                }
            }
            else{
                if(numbers.find(required_operand)->second == 2){
                    number1 = current_operand;
                    number2 = required_operand;
                    index_of_number1 = i;
                    break;
                }
            }
        }

        output_indexes.push_back(index_of_number1);

        for(int i = index_of_number1 + 1; i<nums.size();i++){
            if(nums[i] == number2){
                output_indexes.push_back(i);
                break;
            }
        }

        return output_indexes;
    }

int main() {
    //inputs
    vector<int> nums = {3, 3};
    int target = 6;

    vector<int> output_indexes = twoSum(nums,target);
    return 0;
}
