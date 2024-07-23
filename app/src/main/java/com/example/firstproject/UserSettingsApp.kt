package com.example.firstproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstproject.databinding.ActivityUserSettingsAppBinding

class UserSettingsApp : AppCompatActivity() {
    private var binding: ActivityUserSettingsAppBinding? = null
    private var message = "Switch1:OFF"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserSettingsAppBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.notify?.setOnCheckedChangeListener { _, isChecked ->
            message = if (isChecked) "Switch1:ON" else "Switch1:OFF"
        }

        binding?.btnSave?.setOnClickListener {
            val db = DBHelper(this)
            val name = binding?.useremail?.text.toString()
            val notice = message
            db.addName(name, notice)
            binding?.useremail?.text?.clear()
        }

        binding?.Retrieve?.setOnClickListener {
            val db = DBHelper(this)
            val cursor = db.getName()

            // Clear previous content in rEmail and rnoti before appending new data
            binding?.rEmail?.text = null
            binding?.rnoti?.text = null

            cursor?.apply {
                // Ensure cursor has columns before accessing them
                if (count > 0) {
                    moveToFirst()
                    do {
                        val nameIndex = getColumnIndex(DBHelper.NAME_COL)
                        val ageIndex = getColumnIndex(DBHelper.AGE_COL)

                        // Check if columns exist in the cursor
                        if (nameIndex != -1) {
                            binding?.rEmail?.append(getString(nameIndex) + "\n")
                        }
                        if (ageIndex != -1) {
                            binding?.rnoti?.append(getString(ageIndex) + "\n")
                        }
                    } while (moveToNext())
                }
                close()
            }
        }
    }
}
