// Agent manager in project ier_hf.mas2j

/* Initial beliefs and rules */

/* Initial goals */

/* Plans */

+log_in <- .print("Authentication has begun..."); decision.
+log_out <- set_default;.print("GoodBye!").
+wrong_id <- delete;.print("Wrong format!").
