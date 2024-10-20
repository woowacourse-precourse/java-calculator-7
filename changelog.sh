#!/bin/bash

# Define the output file
OUTPUT_FILE="CHANGELOG.md"

# Check if any arguments are provided
if [ $# -eq 0 ]; then
    # No arguments provided, show all commit messages
    echo "## New Features in This Release" > "$OUTPUT_FILE"
    git log --pretty=format:"- %s" >> "$OUTPUT_FILE"
else
    # Handle arguments
    if [ "$1" == "date" ]; then
        # Show commits with dates, but without the final date
        echo "## New Features in This Release" > "$OUTPUT_FILE"
        git log --pretty=format:"- %s (Date: %ad)" --date=format:'%Y-%m-%d' >> "$OUTPUT_FILE"
    else
        # N is provided, determine how many commits to show
        N="$1"

        # Check if N is a natural number
        if ! [[ "$N" =~ ^[0-9]+$ ]]; then
            echo "N should be a number or null."
            exit 1
        fi

        echo "## New Features in This Release" > "$OUTPUT_FILE"

        if [ "$2" == "date" ]; then
            # Show the latest commit message only without date
            if [ "$N" -eq 1 ]; then
                echo $(date +'%Y-%m-%d') >> "$OUTPUT_FILE"
                git log -n 1 --pretty=format:"- %s" >> "$OUTPUT_FILE"
            else
                git log -n "$N" --pretty=format:"- %s (Date: %ad)" --date=format:'%Y-%m-%d' >> "$OUTPUT_FILE"
            fi
        else
            git log -n "$N" --pretty=format:"- %s" >> "$OUTPUT_FILE"
        fi
    fi
fi
