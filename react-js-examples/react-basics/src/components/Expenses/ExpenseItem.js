import { useState } from "react";

import Card from "../UI/Card";
import "./ExpenseItem.css";


function ExpenseItem(expense) {
    const month = expense.date.toLocaleString("en-US", { month: "2-digit" });
    const date = expense.date.toLocaleString("en-US", { day: "2-digit" });
    const year = expense.date.getFullYear();

    const [ title, setTitle ] = useState(expense.title);

    const clickHandler = () => {
        setTitle("updated");
    }

    return (
        <Card className="expense-item">
            <div className="expense-date">
                {year}-{month}-{date}
            </div>
            <div className="expense-item__description">
                <h2>{title}</h2>
                <div className="expense-item__price">£{expense.amount}</div>
            </div>
            <button onClick={clickHandler}>Change Title</button>
        </Card>
    );
}

export default ExpenseItem;