package dev.rajnish.SplitWise.mapper;

import java.util.ArrayList;
import java.util.List;

import dev.rajnish.SplitWise.dto.ExpenseRequestDTO;
import dev.rajnish.SplitWise.dto.ExpenseResponseDTO;
import dev.rajnish.SplitWise.dto.FriendResponseDTO;
import dev.rajnish.SplitWise.dto.GroupResponseDTO;
import dev.rajnish.SplitWise.dto.UserExpenseResponseDTO;
import dev.rajnish.SplitWise.dto.UserLoginResponseDTO;
import dev.rajnish.SplitWise.model.Expense;
import dev.rajnish.SplitWise.model.Group;
import dev.rajnish.SplitWise.model.User;
import dev.rajnish.SplitWise.model.UserExpense;

public class EntityToDTOMapper {
    
    public static UserLoginResponseDTO userEntityToDTO(User user)
    {
        UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();
        userLoginResponseDTO.setId(user.getId());
        userLoginResponseDTO.setName(user.getName());
        userLoginResponseDTO.setEmail(user.getEmail());
        
        List<GroupResponseDTO> groups = new ArrayList<>();
        for(Group group: user.getGroups())
        {
            groups.add(groupEntityToDTO(group));            
        }

        userLoginResponseDTO.setGroups(groups);

        List<FriendResponseDTO> friends = new ArrayList<>();
        for(User friend: user.getFriends())
        {
            friends.add(friendEntityToDTO(friend));
        }

        userLoginResponseDTO.setFriends(friends);

        return userLoginResponseDTO;        
    }

    public static GroupResponseDTO groupEntityToDTO(Group group)
    {
        GroupResponseDTO groupResponseDTO = new GroupResponseDTO();
        groupResponseDTO.setId(group.getId());
        groupResponseDTO.setName(group.getName());
        groupResponseDTO.setDescription(group.getDescription());
        groupResponseDTO.setExpenseResponseDTOs(new ArrayList<>());
        List<String> groupMembers = new ArrayList<>();

        for(User user: group.getGroupMembers())
        {
            groupMembers.add(user.getName());
        }

        groupResponseDTO.setGroupMembers(groupMembers);
        List<Expense> groupExpenses = group.getExpenses();
        
        if(groupExpenses!=null)
        {
            List<ExpenseResponseDTO> expenseResponseDTOs = new ArrayList<>();
            for(Expense expense: groupExpenses)
            {
                ExpenseResponseDTO expenseResponseDTO = new ExpenseResponseDTO();
                expenseResponseDTO.setCreatedBy(expense.getAddedBy().getName());
                expenseResponseDTO.setId(expense.getId());
                expenseResponseDTO.setTotalAmount(expense.getAmount());
                List<UserExpenseResponseDTO> userExpenseResponseDTOs = new ArrayList<>();
                for(UserExpense userExpense: expense.getUserExpenses())
                {
                    UserExpenseResponseDTO userExpenseResponseDTO = new UserExpenseResponseDTO();
                    userExpenseResponseDTO.setId(userExpense.getId());
                    userExpenseResponseDTO.setUser(userExpense.getUser().getName());
                    userExpenseResponseDTO.setAmount(userExpense.getAmount());
                    userExpenseResponseDTO.setUserExpenseType(userExpense.getUserExpenseType());
                    userExpenseResponseDTOs.add(userExpenseResponseDTO);                    
                }
                expenseResponseDTO.setUserExpenseResponseDTOs(userExpenseResponseDTOs);
                expenseResponseDTOs.add(expenseResponseDTO);
            }

            groupResponseDTO.setExpenseResponseDTOs(expenseResponseDTOs);
        }

        return groupResponseDTO;
    }

    public static FriendResponseDTO friendEntityToDTO(User user)
    {
        FriendResponseDTO friendResponseDTO = new FriendResponseDTO();
        friendResponseDTO.setId(user.getId());
        friendResponseDTO.setName(user.getName());

        return friendResponseDTO;
    }
}
