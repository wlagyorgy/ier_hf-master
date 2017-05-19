// Agent manager in project ier_hf.mas2j

/* Initial beliefs and rules */

/* Initial goals */

/* Plans */

+log_in <- .send(central, tell, hello); .print("Hitelesítés megkezdve.").
+denied <- .print("Hitelesítés hiba.").
+let_in <- .print("Hitelesítés sikeres."); show_buttons.
+log_out <- .print("Viszlát!").
