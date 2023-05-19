#include <iostream>

    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {

        ListNode* output_list = new ListNode();
        ListNode* iter_out = output_list;

        int devreden = 0;
        int sum = 0;
        int output_digit = 0;

        while(true){
            sum = devreden;
            if(l1 != nullptr){
                sum+=l1->val;
                l1 = l1->next;
            }
            if(l2 != nullptr){
                sum+=l2->val;
                l2 = l2->next;
            }

            output_digit = sum % 10;
            devreden = sum / 10;
            iter_out->val = output_digit;

            if(l1 == nullptr && l2 == nullptr){
                if(devreden != 0){
                    iter_out->next = new ListNode();
                    iter_out = iter_out->next;
                    iter_out->val = devreden;
                }
                break;
            }

            iter_out->next = new ListNode();
            iter_out = iter_out->next;
        }

        return output_list;
    }

int main() {
    //inputs
    ListNode *l1;
    ListNode *l2;

    ListNode* output = addTwoNumbers(l1,l2);
    return 0;
}
